import React from 'react';
import EmployeeCard from './EmployeeCard';
import type { Employee } from '../App';

interface EmployeeListProps {
  employees: Employee[];
}

const EmployeeList: React.FC<EmployeeListProps> = ({ employees }) => {
  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>All Employees</h2>

      {employees.length === 0 ? (
        <p style={{ textAlign: 'center' }}>No employees registered yet.</p>
      ) : (
        <div>
          {employees.map(employee => (
            <EmployeeCard key={employee.id} employee={employee} />
          ))}
        </div>
      )}
    </div>
  );
};

export default EmployeeList;
