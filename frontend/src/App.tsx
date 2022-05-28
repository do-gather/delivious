import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminMenu from './pages/AdminMenu';
import Header from './components/Header';
import Main from './pages/Main';
import AdminMenuEdit from './pages/AdminMenuEdit';
import AdminMain from './pages/AdminMain';
import Login from './pages/Login';
import SignUp from './pages/SignUp';
import MyOrderlist from './pages/MyOrderlist';

function App() {
  return (
    <div style={{ backgroundColor: '#E5E5E5', overflow: 'auto', height: '100vh' }}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/admin" element={<AdminMain />} />
          <Route path="/admin/menu" element={<AdminMenu />} />
          <Route path="/admin/menu/edit" element={<AdminMenuEdit />} />
          <Route path="/login" element={<Login />} />
          <Route path="/sign-up" element={<SignUp />} />
          <Route path="/mypage/orderlist" element={<MyOrderlist />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
