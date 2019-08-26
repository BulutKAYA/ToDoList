import React, { Component } from 'react';

import './assets/css/login.css'
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from 'react-router-dom';
import { ToDoList } from './components/ToDoList'
import User from './components/User';

export default class App extends Component {
  render() {

    return (
      <Router>
          <Route exact path='/' component={User} />
          <Route path='/todolit' component={ToDoList} />
      </Router>
    );
  }
}