import React, { useEffect, useState, useRef } from 'react';

import { Link } from 'react-router-dom';

import { DataTable } from 'primereact/datatable';
import { Column } from 'primereact/column';

import { Toast } from 'primereact/toast';
import { Button } from 'primereact/button';

import { fetchVehicles, deleteVehicle } from '../../services/api/vehicleService'

const Table = () => {
  const [data, setData] = useState([]);
  const toast = useRef<any>(null);

  const fetchData = async () => {
    const vehicles = await fetchVehicles();
    setData(vehicles);
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleDelete = async (id: number, vehicleType: string) => {
    await deleteVehicle(id);
    toast.current.show({ severity: 'success', summary: 'Success', detail: `${vehicleType} deleted successfully`, life: 3000 });
    fetchData();
  };

  return (
    <div className='table__container'>

      <Link to='/'><Button icon="pi pi-arrow-left" className="p-button-primary backButton" /></Link>

      <DataTable value={data} tableStyle={{ minWidth: '30rem' }}>
        <Column field="vehicleType" header="Vehicle Type" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="created" header="Created" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="mileage" header="Mileage" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="gearbox" header="Gearbox" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="owner" header="Owner" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="kwAndPs" header="KwAndPs" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="hek" header="Hek" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column field="taxation" header="Taxation" headerStyle={{ backgroundColor: "darkgray" }}></Column>
        <Column header="Delete" headerStyle={{ backgroundColor: "darkgray"}} body={(rowData: any) => {
          return (
            <Button icon="pi pi-trash "className="p-button-danger" onClick={() => handleDelete(rowData.id, rowData.vehicleType)} />
          )
        }
        }></Column>
      </DataTable>

      <Toast ref={toast} position="top-right" />
    </div>
  )
}

export default Table