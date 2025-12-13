import { Component } from '@angular/core';
import { UserService } from '../../services/user';
import { User } from '../../models/User.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-add',
  imports: [CommonModule,FormsModule],
  standalone:true,
  templateUrl: './user-add.html',
  styleUrl: './user-add.css',
})
export class UserAdd {
constructor(private readonly userService:UserService){}
  user:User={
    id:null,
    name:'',
    email:''
  }
addUser(){
  this.userService.addUser(this.user).subscribe(() => {
  alert('User added');
});

}
}
