import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminMenu from './pages/AdminMenu.tsx';
import Header from './components/Header.tsx';
import Main from './pages/Main.tsx';
import AdminMenuEdit from './pages/AdminMenuEdit.tsx';

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
