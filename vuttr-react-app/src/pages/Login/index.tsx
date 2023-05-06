import React, {FormEvent, useEffect, useState} from "react";
import {InputText} from "primereact/inputtext";
import {Card} from "primereact/card";
import {Button} from "primereact/button";
import {useLogin} from "@vuttr/hooks/useLogin";
import {useNavigate} from "react-router-dom";
import {useAuth} from "@vuttr/hooks/useAuth";


export default function Login() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const {mutate, data, isSuccess, isLoading} = useLogin();
    const navigate = useNavigate();
    const auth = useAuth();

    const onSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const request = {login: username, password}
        mutate(request);
    };

    useEffect(() => {
        if (data?.token) {
            auth.signin(
                data.token,
                () => navigate('/home')
            );
        }
    }, [isSuccess, isLoading])

    return (
        <main className="h-screen flex items-center justify-center">
            <Card>
                <div className="m-8">
                    <form className="flex flex-col gap-8 w-full max-w-xs" onSubmit={onSubmit}>
                        <div className="flex flex-col gap-1">
                            <span className="p-float-label">
                                <InputText
                                    id="username"
                                    value={username}
                                    onChange={(e) => setUsername(e.target.value)}/>
                                <label htmlFor="username">Username</label>
                            </span>
                        </div>
                        <div className="flex flex-col gap-1">
                            <span className="p-float-label">
                                <InputText
                                    id="password"
                                    type="password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}/>
                                <label htmlFor="password">Password</label>
                            </span>
                        </div>
                        <Button type="submit" label={isLoading ? 'Loading...' : 'Login'} raised/>
                    </form>
                </div>
            </Card>
        </main>
    );
}
