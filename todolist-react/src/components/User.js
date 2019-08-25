
import React, { Component } from "react";


export class User extends React.Component {
    state = {
        loading: true,
        user: null
    };

    async componentDidMount() {
        const url = 'http://localhost:8080/api/user?email=bulutkaya67@gmail.com&password=123456';
        const response = await fetch(url);
        const data = await response.json();
        this.setState({ user: data, loading: false });
    }

    render() {
        if (this.state.loading) {
            return <div>loading...</div>;
        }
        return (
            <div>
                <div>{this.state.user.username}</div>
                <div>{this.state.user.displayName}</div>
                <div>{this.state.user.email}</div>
            </div>
        );
    }
}