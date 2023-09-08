document.getElementById('form-Task').addEventListener('submit', sendAddTaskRequest)


function sendAddTaskRequest(e){
  e.preventDefault()

  const request = new XMLHttpRequest()

  let title = document.getElementById('title').value
  let description = document.getElementById('description').value

  const data = {
    title, 
    description
  }

  request.open("post", "http://127.0.0.1:8080/tasks/new", true)

  request.setRequestHeader("Content-Type", "application/json")

  request.onreadystatechange = () => {
    if(request.status = 200 && request.readyState == 4){
      const data = JSON.parse(request.response)
      console.log(data);
      document.getElementById('form-Task').reset()
    }
  }

  request.onload = () =>{
    console.log("On Loading ")
  }

  request.send(JSON.stringify(data))

}

function sendFetchTaskRequest(pageNumber = 1){

  const request = new XMLHttpRequest()

  request.open("GET", "http://127.0.0.1:8080/tasks/page/"+pageNumber, true)

  request.setRequestHeader("Content-Type", "application/json")


  request.onreadystatechange = () => {

    if(request.status == 200 && request.readyState == 4){
        const data = JSON.parse(request.response)
        console.log(data);
        renderTask(data)
    }
  }

  request.onload = () => {
    console.log("Loading Data.....");
  }

  request.onerror = (error) => {
    console.log("Server Error : ", error);
  }

  request.send()

}


sendFetchTaskRequest()

function renderTask(data){

  const {totalIntem , totalPage , tasks , message} = data

  let tasksView = document.getElementById('tasks');
  tasksView.innerHTML = '';
  let numbersTemplate = '';
 
  for (let i = 0; i < tasks.length; i++) {
    let title = tasks[i].title;
    let description = tasks[i].description;
 
    tasksView.innerHTML +=
      `<div class="card mb-3">
        <div class="card-body">
        <div class="row">
          <div class="col-sm-3 text-left">
            <p>${title}</p>
          </div>
          <div class="col-sm-7 text-left">
            <p>${description}</p>
          </div>
          <div class="col-sm-2 text-right">
            <a href="#" onclick="deleteTask('${title}')" class="btn btn-danger ml-5">X</a>
          </div>
        </div>  
       </div>
      </div>`;
  }

  for (let i = 0; i < totalPage; i++){
    numbersTemplate += `
      <li class="page-item"><a class="page-link" onClick="sendFetchTaskRequest(${i + 1})" href="#">${(i+1)}</a></li>
    `
  }

  tasksView.innerHTML += `
  <nav aria-label="Page navigation example">
    <ul class="pagination">
      <li class="page-item"><a class="page-link" href="#">Previous</a></li>
      ${numbersTemplate}
      <li class="page-item"><a class="page-link" href="#">Next</a></li>
    </ul>
  </nav>
  `

}


function testing(page = 1){
  alert(page)
}

 
// Save new To-Do
function saveTask(e) {
 
  let title = document.getElementById('title').value;
  let description = document.getElementById('description').value;
 
 
  let task = {
    title,
    description
  };
 
  if (localStorage.getItem('tasks') === null) {
    let tasks = [];
    tasks.push(task);
    localStorage.setItem('tasks', JSON.stringify(tasks));
  } else {
    let tasks = JSON.parse(localStorage.getItem('tasks'));
    tasks.push(task);
    localStorage.setItem('tasks', JSON.stringify(tasks));
  }
 
  getTasks();
 
  // Reset form-Task
  document.getElementById('form-Task').reset();
  e.preventDefault();
 
}
 
// Delete To-Do 
function deleteTask(title) {
 
  let tasks = JSON.parse(localStorage.getItem('tasks'));
  for (let i = 0; i < tasks.length; i++) {
    if (tasks[i].title == title) {
      tasks.splice(i, 1);
    }
  }
 
  localStorage.setItem('tasks', JSON.stringify(tasks));
  getTasks();
}
 
// Show To-Do List
function getTasks() {
 
  let tasks = JSON.parse(localStorage.getItem('tasks'));
  let tasksView = document.getElementById('tasks');
  tasksView.innerHTML = '';
 
  for (let i = 0; i < tasks.length; i++) {
    let title = tasks[i].title;
    let description = tasks[i].description;
 
    tasksView.innerHTML +=
      `<div class="card mb-3">
        <div class="card-body">
        <div class="row">
          <div class="col-sm-3 text-left">
            <p>${title}</p>
          </div>
          <div class="col-sm-7 text-left">
            <p>${description}</p>
          </div>
          <div class="col-sm-2 text-right">
            <a href="#" onclick="deleteTask('${title}')" class="btn btn-danger ml-5">X</a>
          </div>
        </div>  
       </div>
      </div>`;
  }
 
}
 
// getTasks();