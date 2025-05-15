import React, { useState } from 'react';
import type { Employee } from '../App';

interface EmployeeFormProps {
  addEmployee: (employee: Omit<Employee, 'id' | 'status'>) => void;
}

interface FormErrors {
  [key: string]: string;
}

const EmployeeForm: React.FC<EmployeeFormProps> = ({ addEmployee }) => {
  const initialFormState: Omit<Employee, 'id' | 'status'> = {
    fullName: '',
    email: '',
    mobile: '',
    dob: '',
    aadhar: '',
    pan: '',
    address: {
      houseNo: '',
      buildingName: '',
      area: '',
      city: '',
      state: '',
      pincode: '',
    },
  };

  const [formData, setFormData] =
    useState<Omit<Employee, 'id' | 'status'>>(initialFormState);
  const [errors, setErrors] = useState<FormErrors>({});

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;

    if (name.includes('.')) {
      const [parent, child] = name.split('.');
      setFormData({
        ...formData,
        [parent]: {
          ...(formData as any)[parent],
          [child]: value,
        },
      });
    } else {
      setFormData({
        ...formData,
        [name]: value,
      });
    }
  };

  const validateForm = (): boolean => {
    const tempErrors: FormErrors = {};
    let isValid = true;

    // Check required fields
    if (!formData.fullName.trim()) {
      tempErrors.fullName = 'Full name is required';
      isValid = false;
    }

    // Email validation
    if (!formData.email.trim()) {
      tempErrors.email = 'Email is required';
      isValid = false;
    } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
      tempErrors.email = 'Email is invalid';
      isValid = false;
    }

    // Mobile validation
    if (!formData.mobile.trim()) {
      tempErrors.mobile = 'Mobile number is required';
      isValid = false;
    } else if (!/^[0-9]{10}$/.test(formData.mobile)) {
      tempErrors.mobile = 'Mobile number must be 10 digits';
      isValid = false;
    }

    // DOB validation
    if (!formData.dob) {
      tempErrors.dob = 'Date of Birth is required';
      isValid = false;
    }

    // AADHAR validation
    if (!formData.aadhar.trim()) {
      tempErrors.aadhar = 'AADHAR number is required';
      isValid = false;
    } else if (!/^[0-9]{12}$/.test(formData.aadhar)) {
      tempErrors.aadhar = 'AADHAR must be 12 digits';
      isValid = false;
    }

    // PAN validation
    if (!formData.pan.trim()) {
      tempErrors.pan = 'PAN is required';
      isValid = false;
    } else if (!/^[A-Z0-9]{10}$/.test(formData.pan)) {
      tempErrors.pan = 'PAN must be 10 alphanumeric characters';
      isValid = false;
    }

    // Address validation
    if (!formData.address.houseNo.trim()) {
      tempErrors['address.houseNo'] = 'House No is required';
      isValid = false;
    }
    if (!formData.address.area.trim()) {
      tempErrors['address.area'] = 'Area is required';
      isValid = false;
    }
    if (!formData.address.city.trim()) {
      tempErrors['address.city'] = 'City is required';
      isValid = false;
    }
    if (!formData.address.state.trim()) {
      tempErrors['address.state'] = 'State is required';
      isValid = false;
    }
    if (!formData.address.pincode.trim()) {
      tempErrors['address.pincode'] = 'Pincode is required';
      isValid = false;
    } else if (!/^[0-9]{6}$/.test(formData.address.pincode)) {
      tempErrors['address.pincode'] = 'Pincode must be 6 digits';
      isValid = false;
    }

    setErrors(tempErrors);
    return isValid;
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();

    if (validateForm()) {
      addEmployee(formData);
      setFormData(initialFormState);
      alert('Employee registration submitted successfully!');
    }
  };

  const formStyle: React.CSSProperties = {
    maxWidth: '600px',
    margin: '0 auto',
    padding: '20px',
    border: '1px solid #ddd',
    borderRadius: '5px',
  };

  const inputGroupStyle: React.CSSProperties = {
    marginBottom: '15px',
  };

  const inputStyle: React.CSSProperties = {
    width: '100%',
    padding: '8px',
    boxSizing: 'border-box',
    border: '1px solid #ddd',
    borderRadius: '4px',
  };

  const errorStyle: React.CSSProperties = {
    color: 'red',
    fontSize: '12px',
    marginTop: '5px',
  };

  const buttonStyle: React.CSSProperties = {
    background: '#4CAF50',
    color: 'white',
    padding: '10px 15px',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer',
  };

  return (
    <div>
      <h2 style={{ textAlign: 'center' }}>Employee Registration</h2>
      <form onSubmit={handleSubmit} style={formStyle}>
        {/* Personal Information */}
        <div style={{ marginBottom: '20px' }}>
          <h3>Personal Information</h3>

          <div style={inputGroupStyle}>
            <label>Full Name</label>
            <input
              type="text"
              name="fullName"
              value={formData.fullName}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors.fullName && <div style={errorStyle}>{errors.fullName}</div>}
          </div>

          <div style={inputGroupStyle}>
            <label>Email</label>
            <input
              type="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors.email && <div style={errorStyle}>{errors.email}</div>}
          </div>

          <div style={inputGroupStyle}>
            <label>Mobile Number</label>
            <input
              type="text"
              name="mobile"
              value={formData.mobile}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors.mobile && <div style={errorStyle}>{errors.mobile}</div>}
          </div>

          <div style={inputGroupStyle}>
            <label>Date of Birth</label>
            <input
              type="date"
              name="dob"
              value={formData.dob}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors.dob && <div style={errorStyle}>{errors.dob}</div>}
          </div>

          <div style={inputGroupStyle}>
            <label>AADHAR Number</label>
            <input
              type="text"
              name="aadhar"
              value={formData.aadhar}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors.aadhar && <div style={errorStyle}>{errors.aadhar}</div>}
          </div>

          <div style={inputGroupStyle}>
            <label>PAN Number</label>
            <input
              type="text"
              name="pan"
              value={formData.pan}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors.pan && <div style={errorStyle}>{errors.pan}</div>}
          </div>
        </div>

        {/* Address Information */}
        <div>
          <h3>Address</h3>

          <div style={inputGroupStyle}>
            <label>House No</label>
            <input
              type="text"
              name="address.houseNo"
              value={formData.address.houseNo}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors['address.houseNo'] && (
              <div style={errorStyle}>{errors['address.houseNo']}</div>
            )}
          </div>

          <div style={inputGroupStyle}>
            <label>Building Name</label>
            <input
              type="text"
              name="address.buildingName"
              value={formData.address.buildingName}
              onChange={handleChange}
              style={inputStyle}
            />
          </div>

          <div style={inputGroupStyle}>
            <label>Area</label>
            <input
              type="text"
              name="address.area"
              value={formData.address.area}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors['address.area'] && (
              <div style={errorStyle}>{errors['address.area']}</div>
            )}
          </div>

          <div style={inputGroupStyle}>
            <label>City</label>
            <input
              type="text"
              name="address.city"
              value={formData.address.city}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors['address.city'] && (
              <div style={errorStyle}>{errors['address.city']}</div>
            )}
          </div>

          <div style={inputGroupStyle}>
            <label>State</label>
            <input
              type="text"
              name="address.state"
              value={formData.address.state}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors['address.state'] && (
              <div style={errorStyle}>{errors['address.state']}</div>
            )}
          </div>

          <div style={inputGroupStyle}>
            <label>Pincode</label>
            <input
              type="text"
              name="address.pincode"
              value={formData.address.pincode}
              onChange={handleChange}
              style={inputStyle}
            />
            {errors['address.pincode'] && (
              <div style={errorStyle}>{errors['address.pincode']}</div>
            )}
          </div>
        </div>

        <button type="submit" style={buttonStyle}>
          Register Employee
        </button>
      </form>
    </div>
  );
};

export default EmployeeForm;
