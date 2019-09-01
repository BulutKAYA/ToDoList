import React from 'react';
import { login } from '../util/ApiUtil';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import { ACCESS_TOKEN } from '../util/Constants';

export class LoginBox extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
            errors: [],
        };
    }
    showValidationErr(elm, msg) {
        this.setState((prevState) => ({
            errors: [
                ...prevState.errors, {
                    elm,
                    msg
                }
            ]
        }));
    }

    clearValidationErr(elm) {
        this.setState((prevState) => {
            let newArr = [];
            for (let err of prevState.errors) {
                if (elm != err.elm) {
                    newArr.push(err);
                }
            }
            return { errors: newArr };
        });
    }

    onEmailChange(e) {
        this.setState({ email: e.target.value });
        this.clearValidationErr("email");
    }

    onPasswordChange(e) {
        this.setState({ password: e.target.value });
        this.clearValidationErr("password");
    }

    submitLogin(e) {

        if (this.state.username == "") {
            this.showValidationErr("username", "Username Cannot be empty!");
            e.preventDefault();
        }
        if (this.state.email == "") {
            this.showValidationErr("email", "Email Cannot be empty!");
            e.preventDefault();
        }
        if (this.state.password == "") {
            this.showValidationErr("password", "Password Cannot be empty!");
            e.preventDefault();
        }
        const loginRequest = Object.assign({}, this.state);
        const response = login(loginRequest)
        //localStorage.setItem(ACCESS_TOKEN, response.accessToken);
        this.props.onLogin();
        e.preventDefault();
    }
    render() {
        let passwordErr = null,
            emailErr = null;

        for (let err of this.state.errors) {
            if (err.elm == "password") {
                passwordErr = err.msg;
            }
            if (err.elm == "email") {
                emailErr = err.msg;
            }
        }

        return (

            <div className="inner-container">
                <div className="header">
                    Login
                </div>
                <div className="box">

                    <div className="input-group">
                        <label htmlFor="username">Username</label>
                        <input
                            type="text"
                            name="username"
                            className="login-input"
                            placeholder="Username"
                            onChange={this.onEmailChange.bind(this)} />

                        <small className="danger-error">{emailErr ? emailErr : ""}</small>
                    </div>

                    <div className="input-group">
                        <label htmlFor="password">Password</label>
                        <input
                            type="password"
                            name="password"
                            className="login-input"
                            placeholder="Password"
                            onChange={this.onPasswordChange.bind(this)} />

                        <small className="danger-error">{passwordErr ? passwordErr : ""}</small>
                    </div>
                    <Link to="/todolist" className="login-btn" onClick={this.submitLogin.bind(this)}>
                        Login</Link>


                </div>
            </div>
        );
    }

}