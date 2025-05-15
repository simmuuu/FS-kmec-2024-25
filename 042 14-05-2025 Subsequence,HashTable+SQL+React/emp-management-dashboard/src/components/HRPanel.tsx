import React from 'react';
import EmployeeCard from './EmployeeCard';
import type { Employee } from '../App';

interface HRPanelProps {
  employees: Employee[];
}

const HRPanel: React.FC<HRPanelProps> = ({ employees }) => {
  const acceptedEmployees = employees.filter(
    employee => employee.status === 'Accepted'
  );

  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>HR Panel - Accepted Employees</h2>

      {acceptedEmployees.length === 0 ? (
        <p style={{ textAlign: 'center' }}>No accepted employees yet.</p>
      ) : (
        <div>
          {acceptedEmployees.map(employee => (
            <EmployeeCard key={employee.id} employee={employee} />
          ))}
        </div>
      )}
    </div>
  );
};

export default HRPanel;
