import React from 'react';
import {ToDoList} from './todoList'
import { Header } from './inc/header';
import { Footer } from './inc/footer';

import "bootstrap/dist/css/bootstrap.min.css";


function App() {
  const myTask = ["çarşamba gününe kadar yetişmesi gereken işler var"];

  return (
    <div className="App">
      <Header></Header>
      <ToDoList myTaskKey={myTask}></ToDoList>
      <Footer></Footer>
    </div>
  );
}

export default App;
