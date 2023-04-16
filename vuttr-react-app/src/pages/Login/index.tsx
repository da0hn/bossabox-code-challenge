import React, {FormEvent, useCallback} from "react";
import {InputText} from "primereact/inputtext";
import {Card} from "primereact/card";
import {Button} from "primereact/button";

export default function Login() {
    const onFormSubmit = useCallback((event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
    }, []);

    return (
        <main className="h-screen flex items-center justify-center">
            <Card>
                <div className="m-8">
                    <form className="flex flex-col gap-8 w-full max-w-xs" onSubmit={onFormSubmit}>
                        <div className="flex flex-col gap-1">
                            <span className="p-float-label">
                                <InputText id="username"/>
                                <label htmlFor="username">Username</label>
                            </span>
                        </div>
                        <div className="flex flex-col gap-1">
                            <span className="p-float-label">
                                <InputText id="password" type="password"/>
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
