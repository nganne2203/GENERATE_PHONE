import { useState } from 'react';
import axios from 'axios';
import './PhoneNumberGenerator.css';

const API_BASE_URL = 'http://localhost:8080/api/phone-numbers';

function PhoneNumberGenerator() {
  const [quantity, setQuantity] = useState(1);
  const [phoneNumbers, setPhoneNumbers] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  
  const handleQuantityChange = (e) => {
    const value = parseInt(e.target.value);
    if (value > 0 && value <= 1000) {
      setQuantity(value);
      setError('');
    } else if (value > 1000) {
      setError('Maximum quantity allowed is 1000');
      setQuantity(1000);
    } else {
      setQuantity(1);
    }
  };
  
  const generatePhoneNumbers = async () => {
    if (quantity < 1) {
      setError('Please enter a valid quantity');
      return;
    }
    
    setLoading(true);
    setError('');
    
    try {
      const response = await axios.post(`${API_BASE_URL}/generate`, {
        quantity: quantity
      });
      
      if (response.status === 200) {
        setPhoneNumbers(response.data);
      } else {
        setError('Failed to generate all requested phone numbers');
        setPhoneNumbers(response.data || []);
      }
    } catch (err) {
      console.error('Error generating phone numbers:', err);
      setError(err.response?.data?.message || 'Failed to generate phone numbers');
      setPhoneNumbers([]);
    } finally {
      setLoading(false);
    }
  };
  
  return (
    <div className="phone-generator">
      <div className="form-container">
        <div className="form-group">
          <label htmlFor="quantity">How many phone numbers do you want?</label>
          <div className="input-container">
            <input
              type="number"
              id="quantity"
              value={quantity}
              onChange={handleQuantityChange}
              min="1"
              max="1000"
              disabled={loading}
            />
          </div>
        </div>
        
        <button 
          className="generate-btn" 
          onClick={generatePhoneNumbers}
          disabled={loading || quantity < 1}
        >
          {loading ? (
            <span>Generating... <i className="fas fa-spinner fa-spin"></i></span>
          ) : (
            <span>Generate Phone Numbers</span>
          )}
        </button>
      </div>
      
      {error && <div className="error-message">{error}</div>}
      
      {phoneNumbers.length > 0 && (
        <div className="results-container">
          <h2>Generated Phone Numbers</h2>
          <div className="phone-numbers-list">
            {phoneNumbers.map((number, index) => (
              <div className="phone-number-item" key={index}>
                <span className="number">{number}</span>
              </div>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}

export default PhoneNumberGenerator; 