import { Component,OnInit } from '@angular/core';
import { UserService } from '../../services/user';
import { User } from '../../models/User.model';
import {CommonModule} from '@angular/common';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-user-list',
  standalone:true,
  imports: [CommonModule,RouterModule],
  templateUrl: './user-list.html',
  styleUrl: './user-list.css',
})
export class UserList implements OnInit{
  users:User[]=[]
  constructor(private readonly userService:UserService){  }
  ngOnInit():void {
  this.loadUsers();
}
loadUsers(){
this.userService.getUsers().subscribe(data=>{
    this.users=data;
  })
}
deleteUser(id: number) {
  this.userService.deleteUser(id).subscribe(() => {
    this.users = this.users.filter(u => u.id !== id);
  });

}
}
