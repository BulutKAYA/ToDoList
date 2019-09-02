import React from 'react';
import '../assets/css/todolist.css'
import { ACCESS_TOKEN } from '../util/Constants';

export class ToDoList extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            token : ""
        }
    }
    componentDidMount(){
        this.state.token = localStorage.getItem(ACCESS_TOKEN);
    }

    render() {
        
        return (
            <div>
               
            </div>
        );
    }

}

export default ToDoList