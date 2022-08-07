import axios from 'axios';

import { API_URL } from '../utils/constants';
import { authHeader, contentTypeJsonHeader } from '../utils/headerUtils';

/**
 * login과 signup을 위한 서비스
 * api 관련한 부분 처리
 */
class AuthService {
  // eslint-disable-next-line class-methods-use-this
  login(username: string, password: string) {
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
        window.localStorage.clear();
        window.location.reload();
      });
  }

  // eslint-disable-next-line class-methods-use-this
  getUserInfo(token: string, username: string) {
    return axios
      .get(`${API_URL}/users/${username}`, {
        headers: authHeader(token),
      })
      .then(response => {
        if (response.status === 200) {
          if (response.data.type === 'admin') window.localStorage.setItem('adminToken', token);
          else window.localStorage.setItem('userToken', token);
          return response;
        }
        return response;
      })
      .catch(err => {
        console.error(err.response);
        window.localStorage.clear();
        window.location.reload();
      });
  }

  // eslint-disable-next-line class-methods-use-this
  store(store: any, adminToken: string) {
    return axios
      .post(`${API_URL}/store`, store, {
        headers: authHeader(adminToken),
      })
      .then(response => {
        return response;
      })
      .catch(err => {
        console.error(err.response);
        alert('매장명 등록에 실패했습니다.');
      });
  }

  // eslint-disable-next-line class-methods-use-this
  getStore(username: string, adminToken: string) {
    return axios
      .get(`${API_URL}/store/${username}`, {
        headers: authHeader(adminToken),
      })
      .then(response => {
        return response;
      })
      .catch(err => {
        console.error(err.response);
        alert('매장명 조회에 실패했습니다.');
      });
  }

  // eslint-disable-next-line class-methods-use-this
  logout() {
    window.localStorage.removeItem('adminToken');
    window.localStorage.removeItem('userToken');
  }

  // eslint-disable-next-line class-methods-use-this
  register(data: any) {
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
