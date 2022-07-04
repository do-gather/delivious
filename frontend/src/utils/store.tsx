import create from 'zustand';

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
