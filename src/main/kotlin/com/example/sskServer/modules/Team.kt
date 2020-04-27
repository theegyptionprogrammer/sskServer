package com.example.sskServer.modules

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "team")
class Team(val listPlayer: List<Player>)