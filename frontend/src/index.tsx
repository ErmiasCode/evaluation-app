import React from 'react';
import App from './App';

import { createRoot } from 'react-dom/client';

import "primereact/resources/themes/lara-light-indigo/theme.css";     
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";

import { PrimeReactProvider } from 'primereact/api';

const container = document.getElementById('root');
const root = createRoot(container!); // createRoot(container!) if you use TypeScript
root.render(
  <PrimeReactProvider value={{ unstyled: false }}>
        <App/>
  </PrimeReactProvider>
);