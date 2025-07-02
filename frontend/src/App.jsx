import { useState } from 'react'
import './App.css'
import PhoneNumberGenerator from './components/PhoneNumberGenerator'

function App() {
  return (
    <div className="app-container">
      <header>
        <h1>Vietnamese Phone Number Generator</h1>
        <p>Generate unique Vietnamese mobile phone numbers</p>
      </header>
      <main>
        <PhoneNumberGenerator />
      </main>
      <footer>
        <p>&copy; {new Date().getFullYear()} Phone Number Generator</p>
      </footer>
    </div>
  )
}

export default App 