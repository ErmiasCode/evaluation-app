import React from 'react';
import './App.scss';

import { BrowserRouter,Link, Routes, Route } from "react-router-dom";

import { Button } from 'primereact/button';

import Table from './components/Table';

const App: React.FC = () => {
  return (
    <BrowserRouter basename="/evaluation">
      <div className="app">
        <h1 className='app__title'>Evaluation App</h1> 
          <Routes>
            <Route path='/' element={ <Link to='/mytable'><Button label={"MyTabel"} icon={"pi pi-table"}/></Link> } />
            <Route path='/mytable' element={ <Table />} />          
          </Routes>
      </div>
    </BrowserRouter>
  );
};

export default App;
