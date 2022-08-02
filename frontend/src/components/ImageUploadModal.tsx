import React, { useState } from 'react';
import BasicButton from './BasicButton';

/**
 * 이미지 업로드 모달 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
 * @param submitFunction 이미지 업로드 버튼을 누를 때 실행될 함수 받음
 * @param imageUrl 연결되어있는 이미지 url
 */
interface Props {
  onClose: any;
  submitFunction: any;
  imageURL: string;
}

export default function ImageUploadModal({ onClose, submitFunction, imageURL }: Props) {
  const [previewURL, setPreviewURL] = useState(imageURL);

  const fileRef = React.useRef<HTMLInputElement | null>(null);

  const handleFileOnChange = (event: any) => {
    event.preventDefault();
    const reader = new FileReader();
    const addedFile = event.target.files[0];
    reader.onloadend = () => {
      const result = reader.result ? reader.result.toString() : '';
      setPreviewURL(result);
      submitFunction(event.target.files[0], result);
    };
    if (addedFile) reader.readAsDataURL(addedFile);
  };

  const handleUploadButtonClick = () => {
    fileRef.current?.click();
  };

  return (
    <div
      className="absolute left-0 w-full h-screen top-0 z-50"
      style={{ backgroundColor: 'rgba(1,1,1,0.5)', position: 'fixed', overflow: 'hidden' }}
    >
      <div
        className="rounded"
        style={{
          backgroundColor: '#f0f0f0',
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
        }}
      >
        <div
          className="px-4 md:px-40 pt-20 pb-24 mx-2 w-full 
        flex flex-col text-center whitespace-nowrap text-2xl space-y-3"
        >
          {previewURL !== '' && (
            <img className="w-32 h-32 mx-auto rounded-full bg-cover" src={previewURL} alt="메뉴 이미지" />
          )}
          <BasicButton buttonName="메뉴 사진 새로 업로드" onClick={handleUploadButtonClick} height="h-10" />
          <input hidden type="file" accept="image/*" onChange={handleFileOnChange} ref={fileRef} />
          <BasicButton buttonName="저장하기" onClick={onClose} />
        </div>
      </div>
    </div>
  );
}
