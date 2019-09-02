import { API_BASE_URL, AUGMENT_BASE_URL, ACCESS_TOKEN, HEADER_STRING, TOKEN_PREFIX } from './Constants';
import axios from 'axios';

const request = async (options) => {

    var token = localStorage.getItem(ACCESS_TOKEN);

    var header = {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
    }
    
    if(token) {
        header = {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorisation' : token,
        }
    }
    
    try {
        if(options.method == "POST"){
            let res = await axios.post(options.url, options.body, {headers: header});
            if(res.status == 200)
            {
                return res;
            }
        }
        else{
            let res = await axios.get(options.url, options.body, {headers: header});
            if(res.status == 200)
            {
                return res;
            }
        }
    }
    catch (err) {
        console.error(err);
    }
};

export function login(loginRequest) {
    return request({
        url: AUGMENT_BASE_URL + "/signin",
        method: 'POST',
        body: loginRequest
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

    const token = localStorage.getItem(ACCESS_TOKEN)
    return request({
        url: AUGMENT_BASE_URL + "/getuser?token=" + token,
        method: 'GET'
    });
}