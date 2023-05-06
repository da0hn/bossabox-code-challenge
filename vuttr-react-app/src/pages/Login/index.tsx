import React, {FormEvent, useRef, useState} from "react";
import {InputText} from "primereact/inputtext";
import {Card} from "primereact/card";
import {Button} from "primereact/button";
import {useLogin} from "@vuttr/hooks/useLogin";
import {Toast} from "primereact/toast";
import useAuth from "@vuttr/hooks/useAuth";

export default function Login() {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const {mutate, data, isSuccess} = useLogin();
    let auth = useAuth();
    const toast = useRef<Toast>(null);

    const showToast = (
        severity: 'success' | 'info' | 'warn' | 'error' | undefined,
        summary?: string,
        detail?: string
    ) => {
        toast.current?.show({
            severity: severity,
            summary: summary,
            detail: detail,
            life: 3000
        });
    }

    const onSubmit = (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const request = {login: username, password}
        mutate(request);

        if (isSuccess) {
            auth.signin(data!.token);
            showToast(
                'success',
                'Operation Success',
                'Successful login'
            );
        }
    };

    return (
        <main className="h-screen flex items-center justify-center">
            <Toast ref={toast} position="top-right"/>
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
                        <Button type="submit" label="Login" raised/>
                    </form>
                </div>
            </Card>
        </main>
    );
}
