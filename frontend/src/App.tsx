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
import OrderHistory from './pages/OrderHistory';
import AuthRoute from './utils/AuthRoute';

function App() {
  return (
    <div style={{ backgroundColor: '#E5E5E5', overflow: 'auto', height: '100vh' }}>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route element={<AuthRoute pageType="admin" />}>
            <Route path="/" element={<Main />} />
            <Route path="/admin" element={<AdminMain />} />
            <Route path="/admin/menu" element={<AdminMenu />} />
            <Route path="/admin/menu/edit" element={<AdminMenuEdit />} />
          </Route>
          <Route path="/login" element={<Login />} />
          <Route path="/sign-up" element={<SignUp />} />
          <Route path="/mypage/login" element={<Login />} />
          <Route element={<AuthRoute pageType="user" />}>
            <Route path="/mypage/orderlist" element={<MyOrderlist />} />
            <Route path="/mypage/orderlist" element={<MyOrderlist />} />
            <Route path="/mypage/orderhistory" element={<OrderHistory />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
