import {MenuItem} from "primereact/menuitem";
import {Menubar} from "primereact/menubar";
import React from "react";
import {Outlet} from "react-router-dom";


export default function HomeLayout() {
    const items: MenuItem[] = [
        {
            label: 'Basic Management',
            icon: 'pi pi-fw pi-file',
            items: [
                {
                    label: 'Tools',
                    icon: 'pi pi-fw pi-plus',
                    url: '/tools',
                },
                {
                    label: 'Tools?',
                    icon: 'pi pi-fw pi-trash',
                },
                {
                    separator: true
                },
                {
                    label: 'Tools?!?',
                    icon: 'pi pi-fw pi-external-link'
                }
            ]
        },
    ];

    return (
        <main>
            <div className="p-card">
                <Menubar model={items}/>
            </div>
            <Outlet/>
        </main>
    );
}
