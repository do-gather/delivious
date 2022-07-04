import axios from 'axios';

import { API_URL } from '../utils/constants';
import { authHeader, contentTypeJsonHeader } from '../utils/headerUtils';

class AuthService {
  login(username, password) {
    return axios
      .post(`${API_URL}/authenticate`, { username, password })
      .then(response => {
        if (response.status === 200) {
          return response;
        }
        return response;
      })
      .catch(err => {
        console.error(err.response);
        this.localStorage.clear();
        window.location.reload();
      });
  }

  // eslint-disable-next-line class-methods-use-this
  store(store, adminToken) {
    return axios
      .post(`${API_URL}/store`, store, {
        headers: authHeader(adminToken),
      })
      .then(response => {
        return response;
      })
      .catch((err: any) => {
        console.error(err.response);
        alert('매장명 등록에 실패했습니다.');
      });
  }

  logout() {
    window.location.reload();
    this.localStorage.clear();
  }

  // eslint-disable-next-line class-methods-use-this
  register(data) {
    return axios
      .post(`${API_URL}/signup`, data, { headers: contentTypeJsonHeader() })
      .then(response => {
        if (response.status === 201) {
          alert('회원가입에 성공하였습니다.');
        }
        return response;
      })
      .catch(err => {
        console.error(err.response);
        alert(err.response.data.detail);
      });
  }
}

export default new AuthService();
