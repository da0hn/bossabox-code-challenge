import React from "react";
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import Login from "@vuttr/pages/Login";
import {AuthGuard} from "@vuttr/context/AuthContext";
import HomeLayout from "@vuttr/components/HomeLayout";
import Home from "@vuttr/pages/Home";


export default function Router() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/login' element={<Login/>}/>
                <Route element={<AuthGuard children={<HomeLayout/>}/>}>
                    <Route path='/' element={<Navigate to='/home' replace/>}/>
                    <Route path='/home' element={<Home/>}/>
                </Route>
                <Route path='*' element={<AuthGuard children={<HomeLayout/>}/>}/>
            </Routes>
        </BrowserRouter>
    )
}
