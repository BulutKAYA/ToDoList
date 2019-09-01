import { API_BASE_URL, AUGMENT_BASE_URL, ACCESS_TOKEN, HEADER_STRING, TOKEN_PREFIX } from './Constants';
import axios from 'axios';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })
    
    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append(HEADER_STRING, TOKEN_PREFIX + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    if(options.method == "POST"){
        axios.post(options.url, options)
        .then(Response =>{
            return Response
        })
        .catch(error => {
            console.log(error)
        });
    }
    else{
        axios.get(options.url, options)
        .then(Response =>{
            return Response
        })
        .catch(error => {
            console.log(error)
        });
    }

    
};

export function login(loginRequest) {
    return request({
        url: AUGMENT_BASE_URL + "/signin",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}

export function signup(signupRequest) {
    return request({
        url: AUGMENT_BASE_URL + "/signup",
        method: 'POST',
        body: JSON.stringify(signupRequest)
    });
}

export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: AUGMENT_BASE_URL + "/getuser",
        method: 'GET'
    });
}