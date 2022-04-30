import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminMenu from './pages/AdminMenu';
import Header from './components/Header';
import Main from './pages/Main';
import AdminMenuEdit from './pages/AdminMenuEdit';

function App() {
  return (
    <div style={{ backgroundColor: '#E5E5E5' }}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/admin/menu" element={<AdminMenu />} />
          <Route path="/admin/menu/edit" element={<AdminMenuEdit />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
