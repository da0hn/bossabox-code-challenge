import React from "react";
import {Tag} from "primereact/tag";

export default function Home() {
    return (
        <>
            <div className='h-screen flex flex-col gap-8 items-center justify-center text-3xl'>
                <div className='flex flex-row space-x-3.5'>
                    <i className="pi pi-user" style={{fontSize: '2.5rem'}}></i>
                    <h1>Welcome! {'\{Username here\}'}</h1>
                </div>
                <div className='flex flex-col items-center gap-8'>
                    <p>A simple Management System developed in: </p>
                    <ul className='flex align-items gap-5'>
                        <li>
                            <Tag rounded>
                                <div className='flex items-center gap-3 px-5'>
                                    <i className='pi pi-android'></i>
                                    <span className='text-2xl'>Java</span>
                                </div>
                            </Tag>
                        </li>
                        <li>
                            <Tag rounded>
                                <div className='flex items-center gap-3 px-5'>
                                    <i className='pi pi-bitcoin'></i>
                                    <span className='text-2xl'>Spring Boot</span>
                                </div>
                            </Tag>
                        </li>
                        <li>
                            <Tag rounded>
                                <div className='flex items-center gap-3 px-5'>
                                    <i className='pi pi-pencil'></i>
                                    <span className='text-2xl'>Typescript</span>
                                </div>
                            </Tag>
                        </li>
                        <li>
                            <Tag rounded>
                                <div className='flex items-center gap-3 px-5'>
                                    <i className='pi pi-facebook'></i>
                                    <span className='text-2xl'>React</span>
                                </div>
                            </Tag>
                        </li>
                    </ul>
                </div>
            </div>
        </>
    )
}
