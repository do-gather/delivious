function authHeader(access) {
  return { Authorization: `Bearer ${access}`, 'Content-Type': `application/json` };
}

function contentTypeJsonHeader() {
  return { 'Content-Type': `application/json` };
}

module.exports = { authHeader, contentTypeJsonHeader };
