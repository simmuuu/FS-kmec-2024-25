import React from 'react';
import EmployeeCard from './EmployeeCard';
import type { Employee } from '../App';

interface AdminPanelProps {
  employees: Employee[];
  updateEmployeeStatus: (id: number) => void;
}

const AdminPanel: React.FC<AdminPanelProps> = ({
  employees,
  updateEmployeeStatus,
}) => {
  const pendingEmployees = employees.filter(
    employee => employee.status === 'Pending'
  );

  const buttonStyle: React.CSSProperties = {
    backgroundColor: '#4CAF50',
    color: 'white',
    padding: '8px 12px',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer',
    margin: '10px 0',
  };

  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>Admin Panel - Pending Approvals</h2>

      {pendingEmployees.length === 0 ? (
        <p style={{ textAlign: 'center' }}>No pending employee approvals.</p>
      ) : (
        <div>
          {pendingEmployees.map(employee => (
            <div key={employee.id} style={{ marginBottom: '20px' }}>
              <EmployeeCard employee={employee} />
              <button
                style={buttonStyle}
                onClick={() => updateEmployeeStatus(employee.id)}
              >
                Approve Employee
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default AdminPanel;
