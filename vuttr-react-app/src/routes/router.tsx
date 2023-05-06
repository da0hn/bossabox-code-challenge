import React from "react";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Login from "@vuttr/pages/Login";
import Root from "@vuttr/routes/Root";
import {AuthGuard} from "@vuttr/context/AuthContext";


export default function Router() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/login' element={<Login/>}/>
                <Route path='/home' element={<AuthGuard children={<Root/>}/>}/>
                <Route path='*' element={<AuthGuard children={<Root/>}/>}/>
            </Routes>
        </BrowserRouter>
    )
}
