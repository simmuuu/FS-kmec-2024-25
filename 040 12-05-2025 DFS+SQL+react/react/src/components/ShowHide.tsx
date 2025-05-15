import { useState } from 'react';

export default function ShowHide() {
  const [showMsg, setShowMsg] = useState<boolean>(false);
  const [showMsg2, setShowMsg2] = useState<boolean>(false);

  return (
    <div>
      <button onClick={() => setShowMsg(!showMsg)}>
        {showMsg ? 'Hide1' : 'Show1'}
      </button>
      <button onClick={() => setShowMsg2(!showMsg2)}>
        {showMsg2 ? 'Hide2' : 'Show2'}
      </button>
      {showMsg && showMsg2 && <p>both showMsg is currently set to 'true'</p>}
    </div>
  );
}
