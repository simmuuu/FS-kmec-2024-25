import React from 'react';
import type { Employee } from '../App';

interface EmployeeCardProps {
  employee: Employee;
}

const EmployeeCard: React.FC<EmployeeCardProps> = ({ employee }) => {
  const cardStyle: React.CSSProperties = {
    border: '1px solid #ddd',
    borderRadius: '5px',
    padding: '15px',
    marginBottom: '15px',
    backgroundColor: '#000000',
  };

  const titleStyle: React.CSSProperties = {
    margin: '0 0 10px 0',
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
  };

  const statusStyle: React.CSSProperties = {
    display: 'inline-block',
    padding: '5px 10px',
    borderRadius: '3px',
    fontSize: '14px',
    color: 'white',
    backgroundColor: employee.status === 'Pending' ? '#f44336' : '#4CAF50',
  };

  const sectionStyle: React.CSSProperties = {
    marginBottom: '10px',
  };

  return (
    <div style={cardStyle}>
      <div style={titleStyle}>
        <h3 style={{ margin: 0 }}>{employee.fullName}</h3>
        <span style={statusStyle}>{employee.status}</span>
      </div>

      <div style={sectionStyle}>
        <p>
          <strong>Employee ID:</strong> {employee.id}
        </p>
        <p>
          <strong>Email:</strong> {employee.email}
        </p>
        <p>
          <strong>Mobile:</strong> {employee.mobile}
        </p>
        <p>
          <strong>Date of Birth:</strong> {employee.dob}
        </p>
        <p>
          <strong>AADHAR:</strong> {employee.aadhar}
        </p>
        <p>
          <strong>PAN:</strong> {employee.pan}
        </p>
      </div>

      <div>
        <h4 style={{ marginBottom: '5px' }}>Address</h4>
        <p>
          {employee.address.houseNo},{' '}
          {employee.address.buildingName && `${employee.address.buildingName},`}{' '}
          {employee.address.area}, {employee.address.city},{' '}
          {employee.address.state} - {employee.address.pincode}
        </p>
      </div>
    </div>
  );
};

export default EmployeeCard;
