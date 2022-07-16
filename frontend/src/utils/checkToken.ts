import { decodeJwt } from './jwtUtils';
import { dts } from './types';

/**
 * 토큰이 만료되었는지 여부와 토큰 타입을 체크하는 부분, 로그인이 필요한 페이지 접근 시 사용
 */

export default function checkToken() {
  const access = localStorage.getItem('adminToken');
  const userAccess = localStorage.getItem('userToken');
  if (access) {
    // 현재 시각
    const currentTime = new Date().getTime() / 1000;

    // access 토큰 만료 시각
    const accessExpireAt = decodeJwt(access).exp;

    // access 토큰 만료 시간을 임박/초과했을 경우
    if (accessExpireAt - currentTime <= 0) {
      // eslint-disable-next-line no-alert
      alert('로그인이 만료됐어요. 다시 로그인해 주세요.');
      window.localStorage.removeItem('adminToken');
      const token: dts.tokenDto = { activation: false, type: '' };
      return token;
    }
    const token: dts.tokenDto = { activation: true, type: 'admin' };
    return token;
  }
  if (userAccess) {
    // 현재 시각
    const currentTime = new Date().getTime() / 1000;

    // access 토큰 만료 시각
    const accessExpireAt = decodeJwt(userAccess).exp;

    // access 토큰 만료 시간을 임박/초과했을 경우
    if (accessExpireAt - currentTime <= 0) {
      // eslint-disable-next-line no-alert
      alert('로그인이 만료됐어요. 다시 로그인해 주세요.');
      window.localStorage.removeItem('userToken');
      const token: dts.tokenDto = { activation: false, type: 'user' };
      return token;
    }
    const token: dts.tokenDto = { activation: true, type: 'user' };
    return token;
  }
  const token: dts.tokenDto = { activation: false, type: '' };
  return token;
}
