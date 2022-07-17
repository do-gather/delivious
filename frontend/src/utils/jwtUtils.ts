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
