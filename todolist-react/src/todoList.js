import React from 'react';

export class ToDoList extends React.Component{
    render(){
        const taskList = this.props.myTaskKey.map((elem, i) => {
            return(
                <li>
                    <span className="id">{i + 1}</span>
                    <span className="title">{elem}</span>
                    <span className="type" />
                    <span className="delete" />
                </li>
            )
        });
        return(
                <div>
                    ilk Component
                    <li>{this.props.myTaskKey[0]}</li>
                </div>
            )
    }
    
}