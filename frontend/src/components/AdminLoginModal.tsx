import React from 'react';

interface Props {
  onClose: any;
}

export default function AdminLoginModal({ onClose }: Props) {
  return (
    <div
      className="absolute w-full h-screen top-0 z-50"
      style={{ backgroundColor: 'rgba(1,1,1,0.5)', position: 'fixed', overflow: 'hidden' }}
    >
      <div
        className="bg-white rounded-lg px-6 py-9"
        style={{
          position: 'absolute',
          width: '22.5rem ',
          height: '28.625rem',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
        }}
      >
        <div className="w-full flex justify-end ">
          <button type="button" onClick={onClose}>
            close
          </button>
        </div>
        <div className="w-full flex justify-center mb-7">
          <input />
        </div>
      </div>
    </div>
  );
}
