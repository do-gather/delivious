import create from 'zustand';

/**
 * 전역적으로 관리해야할 상태를 저장하는 곳
 * user token 정보를 저장
 */
interface AccessState {
  access: string;
  // eslint-disable-next-line no-unused-vars
  setAccess: (token: string) => void;
  removeAccess: () => void;
}

const useAuth = create<AccessState>(set => ({
  access: '',
  setAccess: (token: string) =>
    set(() => ({
      access: token,
    })),
  removeAccess: () => set({ access: '' }),
}));

export default useAuth;
