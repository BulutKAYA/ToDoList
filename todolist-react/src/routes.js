import React from 'react';
import {BrowserRouter, Route, Redirect, Switch} from 'react-router-dom';


import ToDoList from './components/ToDoList';
import User from './components/User';
import { getCurrentUser } from './util/ApiUtil';


class Routes extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
          currentUser: null,
          isAuthenticated: false,
          isLoading: false
        }
        this.loadCurrentUser = this.loadCurrentUser.bind(this);
    }

    loadCurrentUser() {
        this.setState({
          isLoading: true
        });
        getCurrentUser()
        .then(response => {
          this.setState({
            currentUser: response,
            isAuthenticated: true,
            isLoading: false
          });
        }).catch(error => {
          this.setState({
            isLoading: false
          });  
        });
    }

    handleLogin() {
        this.loadCurrentUser();
    }

    render(){
        return(
            <BrowserRouter >
            <Switch>
            <Route exact path="/" render={(props) => <User onLogin={this.handleLogin.bind(this)} {...props} />}></Route>
            <Route path="/todolist" component={ToDoList}/>
            </Switch>
            </BrowserRouter>
        );
    }

}
export default Routes;