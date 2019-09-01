import React from 'react';
import '../assets/css/todolist.css'
import { ACCESS_TOKEN } from '../util/Constants';

export class ToDoList extends React.Component {

    render() {
        
        return (
            <div>
                 {localStorage.getItem(ACCESS_TOKEN)}
            </div>
        );
    }

}

export default ToDoList