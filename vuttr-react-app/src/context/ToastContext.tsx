import React, {createContext, useRef} from "react";
import {Toast} from "primereact/toast";
import {Outlet} from "react-router-dom";


export type ToastContextParameters = {
    severity: 'success' | 'info' | 'warn' | 'error' | undefined,
    summary?: string,
    detail?: string,
}

export interface ToastContextType {
    show: (parameters: ToastContextParameters) => void
}

export const ToastContext = createContext<ToastContextType>(null!);

export function ToastProvider({children}: { children: React.ReactNode }) {
    const toastRef = useRef<Toast>(null!);

    const showToast = ({severity, summary, detail}: ToastContextParameters) => {
        toastRef.current?.show({
            severity: severity,
            summary: summary,
            detail: detail,
            life: 3000
        });
    }


    const value = {show: showToast}

    return (
        <ToastContext.Provider value={value}>
            <Toast ref={toastRef} position="top-right"/>
            {children ? children : <Outlet/>}
        </ToastContext.Provider>
    );
}
