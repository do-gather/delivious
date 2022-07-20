/**
 * jwt를 읽고 토큰의 유효성을 검사
 * @param token jwt token을 받아옴
 * @returns jwt token의 payload를 반환
 */

function decodeJwt(token: string) {
  const base64Url = token.split('.')[1];
  const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  const jsonPayload = decodeURIComponent(
    atob(base64)
      .split('')
      // eslint-disable-next-line func-names
      .map(function (c) {
        return `%${`00${c.charCodeAt(0).toString(16)}`.slice(-2)}`;
      })
      .join(''),
  );

  return JSON.parse(jsonPayload);
}

function parseJwt(token: string) {
  if (!token) {
    return;
  }

  const base64Url = token.split('.')[1];
  const base64 = base64Url.replace('-', '+').replace('_', '/');

  // eslint-disable-next-line consistent-return
  return JSON.parse(window.atob(base64));
}

export { decodeJwt, parseJwt };
