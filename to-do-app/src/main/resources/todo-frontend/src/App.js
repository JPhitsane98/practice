import React, { useState, useEffect } from 'react';
import Modal from 'react-modal';
import './App.css';
import AddTaskModal from './AddTaskModal';

function App() {
  const [tasks, setTasks] = useState([]);
  const [newTaskModalOpen, setNewTaskModalOpen] = useState(false);

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = () => {
     fetch('http://localhost:8081/api/v1/tasks')
         .then(response => response.json())
         .then(data => setTasks(data))
         .catch(error => console.error('Error fetching tasks:', error));
  };

  const handleAddTask = newTask => {
    setTasks([...tasks, newTask]);
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Welcome,</h1>
        <h2>My Tasks</h2>
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Due Date</th>
            </tr>
          </thead>
          <tbody>
            {tasks.map(task => (
              <tr key={task.name}>
                <td>{task.name}</td>
                <td>{task.description}</td>
                <td>{task.dueDate}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <button className="add-task-button" onClick={() => setNewTaskModalOpen(true)}>
           <span className="plus-icon">+</span> Add Task
        </button>
        <AddTaskModal
          isOpen={newTaskModalOpen}
          onClose={() => setNewTaskModalOpen(false)}
          onAddTask={handleAddTask}
        />
      </header>
    </div>
  );
}

export default App;
