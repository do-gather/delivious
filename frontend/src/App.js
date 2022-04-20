import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminMenu from './pages/AdminMenu.tsx';
import Header from './components/Header.tsx';
import Main from './pages/Main.tsx';

function App() {
  return (
    <div>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/admin/menu" element={<AdminMenu />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
