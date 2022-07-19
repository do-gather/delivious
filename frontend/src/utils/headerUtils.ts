/**
 * api 연결 시 이용되는 header
 */

function authHeader(access: string) {
  return { Authorization: `Bearer ${access}`, 'Content-Type': `application/json` };
}

function contentTypeJsonHeader() {
  return { 'Content-Type': `application/json` };
}

export { authHeader, contentTypeJsonHeader };
