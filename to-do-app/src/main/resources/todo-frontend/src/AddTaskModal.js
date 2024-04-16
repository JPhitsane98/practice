import React, { useState } from 'react';
import Modal from 'react-modal';

const AddTaskModal = ({ isOpen, onClose, onAddTask }) => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [dueDate, setDueDate] = useState('');

  const handleAddTask = () => {
    fetch('http://localhost:8081/api/v1/tasks/save', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, description, dueDate }),
      })
        .then(response => response.json())
        .then(data => {
          onAddTask(data); // Assuming the server returns the created task
          onClose();
        })
        .catch(error => console.error('Error adding task:', error));
  };

  return (
    <Modal
      isOpen={isOpen}
      onRequestClose={onClose}
      contentLabel="Add Task Modal"
    >
      <h2>Add Task</h2>
      <input
        type="text"
        placeholder="Name"
        value={name}
        onChange={e => setName(e.target.value)}
      />
      <input
        type="text"
        placeholder="Description"
        value={description}
        onChange={e => setDescription(e.target.value)}
      />
      <input
        type="date"
        value={dueDate}
        onChange={e => setDueDate(e.target.value)}
      />
      <button onClick={handleAddTask}>Add Task</button>
      <button onClick={onClose}>Cancel</button>
    </Modal>
  );
};

export default AddTaskModal;
