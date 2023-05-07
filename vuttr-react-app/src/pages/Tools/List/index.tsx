import React from "react";
import {Fieldset} from "primereact/fieldset";
import {DataTable} from "primereact/datatable";
import {Column, ColumnBodyOptions} from "primereact/column";
import useTools, {ToolTableItem} from "@vuttr/hooks/useTools";
import {Button} from "primereact/button";


export default function ListTools() {
    const {data, isLoading} = useTools();

    const handleEditTool = (data: ToolTableItem) => {
        console.log({...data});
    };

    const handleDeleteTool = (data: ToolTableItem) => {
        console.log({...data});
    };

    const actionsTemplate = (data: ToolTableItem, _: ColumnBodyOptions) => {
        return (<>
            <div className='flex flex-row content-center gap-2.5 mx-2 px-2'>
                <Button
                    onClick={e => handleEditTool(data)}
                    icon="pi pi-pencil" rounded severity="secondary" aria-label="Edit Book"/>
                <Button
                    onClick={e => handleDeleteTool(data)}
                    icon="pi pi-trash" rounded severity="danger" aria-label="Delete Book"/>
            </div>
        </>)
    };

    const legendTemplate = (
        <div className="flex flex-row items-center justify-center text-primary px-5">
            <span className="pi pi-user mr-2"></span>
            <span className="font-bold text-lg">Tools</span>
        </div>
    );

    return (
        <div className='h-screen p-10 gap-2.5'>
            <Fieldset legend={legendTemplate}>
                <div className='flex flex-col'>
                    <div className='flex mr-3 justify-end'>
                        <Button label='New Tool' icon='pi pi-plus'></Button>
                    </div>
                    <div className='m-3'>
                        <DataTable value={data}>
                            <Column field='id' header='Code' bodyStyle={{textAlign: 'center'}} alignHeader='center'/>
                            <Column field='title' header='Title' bodyStyle={{minWidth: '10rem', textAlign: 'initial'}}
                                    alignHeader='center'/>
                            <Column field='description' header='Description' bodyStyle={{textAlign: 'initial'}}
                                    alignHeader='center'/>
                            <Column header='Actions' body={actionsTemplate} alignHeader='center'/>
                        </DataTable>
                    </div>
                </div>
            </Fieldset>
        </div>
    );
}
